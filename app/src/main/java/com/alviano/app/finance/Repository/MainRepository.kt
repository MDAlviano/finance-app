package com.alviano.app.finance.Repository

import com.alviano.app.finance.Domain.ExpenseDomain

class MainRepository {

    val items = mutableListOf(
        ExpenseDomain("Restaurant", 573.12, "img1", "17 jun 2024 19:15"),
        ExpenseDomain("Mcdonald", 77.82, "img2", "15 jun 2024 21:54"),
        ExpenseDomain("Cinema", 23.47, "img3", "14 jun 2024 07:39"),
        ExpenseDomain("Restaurant", 341.12, "img1", "12 jun 2024 12:46"),
    )

}