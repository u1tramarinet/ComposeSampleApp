package com.u1tramarinet.composesampleapp.ui

import androidx.navigation.NavHostController
import com.u1tramarinet.composesampleapp.ui.NavDestinationsArg.ARG_PRODUCT_ID
import com.u1tramarinet.composesampleapp.ui.NavDestinationsArg.ARG_PRODUCT_NAME
import com.u1tramarinet.composesampleapp.ui.NavScreens.SCREEN_ADD_PRODUCT
import com.u1tramarinet.composesampleapp.ui.NavScreens.SCREEN_PRODUCT_DETAIL
import com.u1tramarinet.composesampleapp.ui.NavScreens.SCREEN_PRODUCT_LIST

private object NavScreens {
    const val SCREEN_PRODUCT_LIST = "productList"
    const val SCREEN_ADD_PRODUCT = "addProduct"
    const val SCREEN_PRODUCT_DETAIL = "productDetail"
}

object NavDestinationsArg {
    const val ARG_PRODUCT_NAME = "product_name"
    const val ARG_PRODUCT_ID = "product_id"
}

object NavDestinations {
    const val ROUTE_PRODUCT_LIST = SCREEN_PRODUCT_LIST
    const val ROUTE_ADD_PRODUCT = SCREEN_ADD_PRODUCT
    const val ROUTE_PRODUCT_DETAIL =
        "$SCREEN_PRODUCT_DETAIL/$ARG_PRODUCT_NAME?$ARG_PRODUCT_ID=$ARG_PRODUCT_ID"
}

class NavActions(private val navController: NavHostController) {

    fun navigateToProductList() {
        navController.navigate(SCREEN_PRODUCT_LIST)
    }

    fun navigateToAddProduct() {
        navController.navigate(SCREEN_ADD_PRODUCT)
    }

    fun navigateToProductDetail(productId: Int, productName: String) {
        navController.navigate("$SCREEN_PRODUCT_DETAIL/$productName?$ARG_PRODUCT_ID=$productId")
    }
}