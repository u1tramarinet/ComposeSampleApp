package com.u1tramarinet.composesampleapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.u1tramarinet.composesampleapp.ui.NavDestinationsArg.ARG_PRODUCT_ID
import com.u1tramarinet.composesampleapp.ui.NavDestinationsArg.ARG_PRODUCT_NAME
import com.u1tramarinet.composesampleapp.ui.addproduct.AddProductScreen
import com.u1tramarinet.composesampleapp.ui.productdetail.ProductDetailScreen
import com.u1tramarinet.composesampleapp.ui.productlist.ProductListScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavDestinations.ROUTE_PRODUCT_LIST,
    navActions: NavActions = remember(navController) {
        NavActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(NavDestinations.ROUTE_PRODUCT_LIST) {
            ProductListScreen(
                onAddProduct = { navActions.navigateToAddProduct() },
                onProductDetail = { product ->
                    navActions.navigateToProductDetail(product.id, product.name)
                },
            )
        }
        composable(NavDestinations.ROUTE_ADD_PRODUCT) {
            AddProductScreen(onBack = { navController.popBackStack() })
        }
        composable(
            NavDestinations.ROUTE_PRODUCT_DETAIL,
            arguments = listOf(
                navArgument(ARG_PRODUCT_ID) { type = NavType.IntType },
                navArgument(ARG_PRODUCT_NAME) { type = NavType.StringType },
            ),
        ) { entry ->
            val productId = entry.arguments?.getInt(ARG_PRODUCT_ID).let { it ?: -1 }
            val productName = entry.arguments?.getString(ARG_PRODUCT_NAME).let { it ?: "" }
            ProductDetailScreen(
                productName = productName,
                productId = productId,
                onBack = { navController.popBackStack() })
        }
    }
}