import java.io.*;
import java.util.*;

/*
 1개의 면 최솟값 -> minOne
 2개의 면 최솟값 -> minTwo
 3개의 면 최솟 값 -> minThree

 1개가 보이는 면 -> (N-2)^2 * 5 * (minOne) + (N-2) * 4 * (minOne)
 2개가 보이는 수직면 -> (4(N-1)*(minTwo))
 2개가 보이는 수평면 -> (4(N-2)*(minTwo))
 3개가 보이는 면 -> 4 * (minThree)

 A B C D E F
 0 1 2 3 4 5

 (A,F)-(0,5)
 (B,E)-(1,4)
 (C,D)-(2,3)

 마지막으로 n이 1일때
 A+B+C+D+E+F - max
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n: Long = br.readLine().toLong()
    var numList: List<Int> = br.readLine().split(" ").map{it.toInt()}

    if (n == 1L) {
        val sum: Int = numList.sum()
        val max = numList.maxOrNull()!!
        println(sum - max)
        return
    }

    val minOne: Int = getMinOne(numList)
    val minTwo: Int = getMinTwo(numList)
    val minThree: Int = getMinThree(numList)

    // println("minOne: $minOne")
    // println("minTwo: $minTwo")
    // println("minThree: $minThree")

    val one: Long = ((n-2)*(n-2) * 5 * minOne) + ((n-2) * 4 * minOne)
    val twoH: Long = 4 * (n-1) * minTwo
    val twoV: Long = 4 * (n-2) * minTwo
    val three: Long = 4L * minThree
    println(one + twoH + twoV + three)
}

fun getMinOne(numList: List<Int>): Int {
    var min = numList[0]
    for (i: Int in 0..5 ) {
        min = minOf(min, numList[i])
    }
    return min
}

fun getMinTwo(numList: List<Int>): Int {
    var min = numList[0] + numList[1]

    for (i in 0..5) {
        for (j in i + 1..5) {
            if (isFaceOff(i, j)) continue
            min = minOf(min, numList[i] + numList[j])
        }
    }
    return min
}

fun getMinThree(numList: List<Int>): Int {
    var min = numList[0] + numList[1] + numList[2];

    for (i in 0..5) {
        for (j in i + 1..5) {
            if (isFaceOff(i, j)) continue

            for (k in j + 1..5) {
                if (isFaceOff(i, k) || isFaceOff(j, k)) continue
                min = minOf(min, numList[i] + numList[j] + numList[k])
            }
        }
    }
    return min
}

fun isFaceOff(a: Int, b: Int): Boolean {
    return a + b == 5
}