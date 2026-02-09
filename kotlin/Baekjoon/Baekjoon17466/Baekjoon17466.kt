import java.io.*;
import java.util.*;

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var ans: Long = 1;
    val arr: List<Long> = br.readLine().split(" ").map{it.toLong()};
    
    for (i: Long in 2..arr[0]) {
        ans = ((ans % arr[1]) * (i % arr[1])) % arr[1];
    }
    println(ans)
}