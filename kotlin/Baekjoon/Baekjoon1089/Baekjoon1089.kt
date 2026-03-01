import java.io.*;
import java.util.*;

class Baekjoon1041 {
    lateinit var inputList: MutableList<Int>
    lateinit var numList: List<Int>
    var n: Int = 0
    var ans: Double = 0.0

    init {
        input()
        solve()
        output()
    }

    fun input() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        this.n = Integer.parseInt(br.readLine())
        this.inputList = ArrayList()
        val input: MutableList<String> = ArrayList()
        for (i in 0 until 5) {
            input.add(
                br.readLine()
                    .replace('#', '1')
                    .replace('.', '0')
            )
        }
        for (i in 0 until 4*n step 4) {
            inputList.add(Integer.parseInt( 
                input[0].substring(i, i+3) +
                input[1].substring(i, i+3) +
                input[2].substring(i, i+3) +
                input[3].substring(i, i+3) +
                input[4].substring(i, i+3)
                , 2))
        }
    }

    fun output() {
        println(ans)
    }

    fun solve() {
        setNumberBitmapList()

        for (pos in 0 until n) {

            val candidates = mutableListOf<Int>()

            for (digit in 0..9) {
                if ((inputList[pos] and numList[digit]) == inputList[pos]) {
                    candidates.add(digit)
                }
            }

            if (candidates.isEmpty()) {
                this.ans = -1.0
                return
            }

            val avg = candidates.average()

            val weight = Math.pow(10.0, (n - pos - 1).toDouble())

            this.ans += avg * weight
        }
    }

    fun setNumberBitmapList() {
        val numbers = listOf(
            listOf("111","101","101","101","111"), // 0
            listOf("001","001","001","001","001"), // 1
            listOf("111","001","111","100","111"), // 2
            listOf("111","001","111","001","111"), // 3
            listOf("101","101","111","001","001"), // 4
            listOf("111","100","111","001","111"), // 5
            listOf("111","100","111","101","111"), // 6
            listOf("111","001","001","001","001"), // 7
            listOf("111","101","111","101","111"), // 8
            listOf("111","101","111","001","111")  // 9
        )

        numList = numbers.map { rows ->
            rows.joinToString("").toInt(2)
        }
    }
}

fun main() {
    Baekjoon1041()
}
