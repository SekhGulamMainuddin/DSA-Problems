fun main() {
    val n = readln().toInt()
    val ans = ArrayList<ArrayList<Int>>()

    repeat(n) { _ ->
        val length = readln().toInt()
        val string = readln()
        val indexMarking = Array(length, {
            false
        })
        val list = string.split(" ").map {
            it.toInt()
        }

        for (i in 1..100) {
            for (j in 0 until length) {
                if (list[j] <= i) {
                    indexMarking[j] = true
                    break
                }
            }
        }

        val tempAns = ArrayList<Int>()
        for (i in 0 until length) {
            if (!indexMarking[i]) {
                tempAns.add(i + 1)
            }
        }
        ans.add(tempAns)
    }

    ans.forEach {
        println(it.size)
        it.forEach { i ->
            print("$i ")
        }
        println()
    }
}