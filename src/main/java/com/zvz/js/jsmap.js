var swingNames = JavaImporter();

swingNames.importPackage(Packages.java.lang);
swingNames.importPackage(Packages.co.test);

obj = {a:1, b:['x','y']}
next = isPrime
flag = isPrime(5)
with (swingNames) {
    System.out.println("in javascript");
    JSFunction.print("in JSFunction");
    jsFunction = new JSFunction("lichunlei");
    var name = jsFunction.getName();
    System.out.println("get name from java source: " + name);
    jsFunction.setHandler(log);
}

java.lang.System.out.println("not use swingNames");
function isPrime (num)
{
    java.lang.System.out.println("in isPrime(num)");
    if (num <= 1) {
        java.lang.System.out.println("Please enter a positive integer >= 2.")
        return false
    }

    var prime = true
    var sqrRoot = Math.round(Math.sqrt(num))

    for (var n = 2; prime & n <= sqrRoot; ++n) {
        prime = (num % n != 0)
    }

    return prime
}

function log(msg)
{
    java.lang.System.out.println("in function log: " + msg);
}
