package com.zvz.lucene;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Date;

public class LuceneTest {

   /* 为了对文档进行索引，Lucene 提供了五个基础的类，他们分别是 Document, Field, IndexWriter, Analyzer, Directory。下面我们分别介绍一下这五个类的用途：
    Document
    Document 是用来描述文档的，这里的文档可以指一个 HTML 页面，一封电子邮件，或者是一个文本文件。
    一个 Document 对象由多个 Field 对象组成的。可以把一个 Document 对象想象成数据库中的一个记录，
    而每个 Field 对象就是记录的一个字段。

    Field
    Field 对象是用来描述一个文档的某个属性的，比如一封电子邮件的标题和内容可以用两个 Field 对象
    分别描述。

    IndexWriter
    IndexWriter 是 Lucene 用来创建索引的一个核心的类，他的作用是把一个个的 Document 对象加到索引
    中来。

    Analyzer
    在一个文档被索引之前，首先需要对文档内容进行分词处理，这部分工作就是由 Analyzer 来做的。
    Analyzer 类是一个抽象类，它有多个实现。针对不同的语言和应用需要选择适合的 Analyzer。
    Analyzer 把分词后的内容交给 IndexWriter 来建立索引。

    Directory
    这个类代表了 Lucene 的索引的存储的位置，这是一个抽象类，它目前有两个实现，
    第一个是 FSDirectory，它表示一个存储在文件系统中的索引的位置。第二个是 RAMDirectory，
    它表示一个存储在内存当中的索引的位置。*/

    @Test
    public void test01() throws IOException {
      /* 建立索引*/
        //存储索引文件夹
        Directory dir = FSDirectory.open(Paths.get("E:\\luceneData", new String[0]));
        //源文件夹
        File dataDir = new File("E:\\lucenetest");
        Analyzer luceneAnalyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(luceneAnalyzer);
        File[] dataFiles = dataDir.listFiles();
        IndexWriter indexWriter = new IndexWriter(dir, iwc);
        long startTime = new Date().getTime();
        for (int i = 0; i < dataFiles.length; i++) {
            if (dataFiles[i].isFile() && dataFiles[i].getName().endsWith(".txt")) {
                System.out.println("Indexing file " + dataFiles[i].getCanonicalPath());
                Document document = new Document();
                Reader txtReader = new FileReader(dataFiles[i]);
                document.add(new StringField("path", dataFiles[i].getCanonicalPath(), Field.Store.YES));
                document.add(new TextField("contents", txtReader));
                indexWriter.addDocument(document);
            }
        }
        indexWriter.close();
        long endTime = new Date().getTime();

        System.out.println("It takes " + (endTime - startTime)
                + " milliseconds to create index for the files in directory "
                + dataDir.getPath());

    }


    /* 搜索*/
    @Test
    public void test02() throws IOException, ParseException {

        String queryStr = "movecar";
        String field = "contents";
        int hitsPerPage = 10;
        boolean raw = false;
        //索引存放路径
        String index = "E:\\luceneData";

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index, new String[0])));
        IndexSearcher searcher = new IndexSearcher(reader);
        Analyzer analyzer = new StandardAnalyzer();
        QueryParser parser = new QueryParser(field, analyzer);

        Query query = parser.parse(queryStr);
        System.out.println("Searching for: " + query.toString(field));

        searcher.search(query, 100);

        doPagingSearch(in, searcher, query, hitsPerPage, raw, false);

        reader.close();
    }


    public static void doPagingSearch(BufferedReader in, IndexSearcher searcher, Query query, int hitsPerPage, boolean raw, boolean interactive)
            throws IOException {
        TopDocs results = searcher.search(query, 5 * hitsPerPage);
        ScoreDoc[] hits = results.scoreDocs;

        int numTotalHits = results.totalHits;
        System.out.println(numTotalHits + " total matching documents");

        int start = 0;
        int end = Math.min(numTotalHits, hitsPerPage);
        while (true) {
            if (end > hits.length) {
                System.out.println("Only results 1 - " + hits.length + " of " + numTotalHits + " total matching documents collected.");
                System.out.println("Collect more (y/n) ?");
                String line = in.readLine();
                if ((line.length() == 0) || (line.charAt(0) == 'n')) {
                    break;
                }
                hits = searcher.search(query, numTotalHits).scoreDocs;
            }

            end = Math.min(hits.length, start + hitsPerPage);

            for (int i = start; i < end; i++) {
                if (raw) {
                    System.out.println("doc=" + hits[i].doc + " score=" + hits[i].score);
                } else {
                    Document doc = searcher.doc(hits[i].doc);
                    String path = doc.get("path");
                    if (path != null) {
                        System.out.println(i + 1 + ". " + path);
                        String title = doc.get("title");
                        if (title != null)
                            System.out.println("   Title: " + doc.get("title"));
                    } else {
                        System.out.println(i + 1 + ". No path for this document");
                    }
                }
            }

            if ((!interactive) || (end == 0)) {
                break;
            }
            if (numTotalHits >= end) {
                boolean quit = false;
                while (true) {
                    System.out.print("Press ");
                    if (start - hitsPerPage >= 0) {
                        System.out.print("(p)revious page, ");
                    }
                    if (start + hitsPerPage < numTotalHits) {
                        System.out.print("(n)ext page, ");
                    }
                    System.out.println("(q)uit or enter number to jump to a page.");

                    String line = in.readLine();
                    if ((line.length() == 0) || (line.charAt(0) == 'q')) {
                        quit = true;
                        break;
                    }
                    if (line.charAt(0) == 'p') {
                        start = Math.max(0, start - hitsPerPage);
                        break;
                    }
                    if (line.charAt(0) == 'n') {
                        if (start + hitsPerPage >= numTotalHits) break;
                        start += hitsPerPage;
                        break;
                    }

                    int page = Integer.parseInt(line);
                    if ((page - 1) * hitsPerPage < numTotalHits) {
                        start = (page - 1) * hitsPerPage;
                        break;
                    }
                    System.out.println("No such page");
                }

                if (quit) break;
                end = Math.min(numTotalHits, start + hitsPerPage);
            }
        }
    }
}
