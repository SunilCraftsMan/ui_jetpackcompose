package com.example.jetpackbasicui.ui.helper

import com.example.jetpackbasicui.R
import com.example.jetpackbasicui.ui.theme.Beige1
import com.example.jetpackbasicui.ui.theme.Beige2
import com.example.jetpackbasicui.ui.theme.Beige3
import com.example.jetpackbasicui.ui.theme.BlueViolet1
import com.example.jetpackbasicui.ui.theme.BlueViolet2
import com.example.jetpackbasicui.ui.theme.BlueViolet3
import com.example.jetpackbasicui.ui.theme.LightGreen1
import com.example.jetpackbasicui.ui.theme.LightGreen2
import com.example.jetpackbasicui.ui.theme.LightGreen3
import com.example.jetpackbasicui.ui.theme.OrangeYellow1
import com.example.jetpackbasicui.ui.theme.OrangeYellow2
import com.example.jetpackbasicui.ui.theme.OrangeYellow3
import com.example.jetpackbasicui.ui.theme.skyBlue1
import com.example.jetpackbasicui.ui.theme.skyBlue2
import com.example.jetpackbasicui.ui.theme.skyBlue3

fun CouseDatas(): List<Course> {
    return listOf(
        Course(
            title = "Android",
            "$ 17",
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Course(
            title = "Machine Learning",
            cost = "$ 25",
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Course(
            title = "Advance python Course",
            cost = "$ 20",
            skyBlue1,
            skyBlue2,
            skyBlue3
        ),
        Course(
            title = "Advance Java Course",
            cost = "$ 20",
            Beige1,
            Beige2,
            Beige3
        ),
        Course(
            title = "prepare for aptitude test",
            cost = "$ 8",
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        Course(
            title = "Data Science",
            cost = "$ 25",
            LightGreen1,
            LightGreen2,
            LightGreen3
        )
    )
}