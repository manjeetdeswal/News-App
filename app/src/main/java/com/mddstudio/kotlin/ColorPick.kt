package com.mddstudio.kotlin

import com.mddstudio.kotlin.ColorPick.colors

object ColorPick {
    val colors = arrayOf(
        "#719c70",
        "#f24a33",
        "#f46732",
        "#ecf9f4",
        "#f35a2c",
        "#f46732",
        "#f24a33",
        "#f8f8ff",
        "#e43553",
        "#a4e2c9",
        "#73bcff",
        "#4766ff",
        "#05ffa1",
        "#01cdfe"
    )


    var colorIndex = 1
    fun getColor(): String {
        return colors[colorIndex++ % colors.size]

    }
}