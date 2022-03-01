package com.dms.wordle.appData

import com.dms.wordle.models.PerfectPosition
import com.dms.wordle.models.YellowPosition

object MainLogic {
    @JvmStatic
    fun filterData(
        grey: ArrayList<String>,
        yellow: ArrayList<YellowPosition>,
        green: ArrayList<PerfectPosition>,
        listOfFiveChar: ArrayList<String>
    ): ArrayList<String> {

        if (yellow.size > 0) {
            for (i in 0 until yellow.size) {
                var num = 0
                while (num <= grey.size - 1) {
                    if (yellow[i].char.uppercase() == grey[num].uppercase()) {
                        grey.removeAt(num)
                        num--
                    }
                    num++
                }
            }
        }

        if (green.size > 0) {
            for (i in 0 until green.size) {
                var num = 0
                while (num <= grey.size - 1) {
                    if (green[i].char == grey[num].uppercase()) {
                        grey.removeAt(num)
                        num--
                    }
                    num++
                }
            }
        }

        var list = ArrayList<String>()

        if (grey.size > 0 || yellow.size > 0 || green.size > 0) {
            if (grey.size > 0) {
                for (i in 0 until grey.size) {
                    list = listOfFiveChar.filter {
                        !it.uppercase().contains(grey[i].uppercase())
                    } as ArrayList<String>
                    listOfFiveChar.clear()
                    listOfFiveChar.addAll(list)
                }
            } else {
                list.addAll(listOfFiveChar)
            }

//            if (yellow.size > 0) {
//                for (i in 0 until yellow.size) {
//                    list = list.filter { it.uppercase().contains(yellow[i].char.uppercase())
//                    } as ArrayList<String>
//                }
//            }

            if (yellow.size > 0) {
                for (i in 0 until yellow.size) {
                    list = list.filter {
                        it[yellow[i].notPosition].toString()
                            .uppercase() != yellow[i].char.uppercase() && it.uppercase().contains(yellow[i].char.uppercase())
                    } as ArrayList<String>
                }
            }


            if (green.size > 0) {
                for (i in 0 until green.size) {
                    list = list.filter { it[green[i].position].toString().uppercase() == green[i].char.uppercase()
                        } as ArrayList<String>
                }
            }
        } else {
            list.addAll(listOfFiveChar)
        }
        return list
    }
}