fun main() {
    val arr: List<Int> = readln().split(" ").map { it.toInt() }
    var ans: Int = 0;
    var a: Int = arr[0] + arr[1] + arr[2] + arr[3];
    var b: Int = arr[4] * 4;

    while (a < b) {
        ++ans;
        ++a;
    }
    println(ans);
}