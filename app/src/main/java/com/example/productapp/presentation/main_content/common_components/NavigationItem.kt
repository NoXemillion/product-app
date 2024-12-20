package com.example.productapp.presentation.main_content.common_components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val route : String ,
    val title : String,
    val icon : ImageVector
){
    object Home : NavigationItem("home" , "Home" , Icons.Default.Home)
    object Wishlist : NavigationItem("wishlist", "Wishlist" , Icons.Default.FavoriteBorder)
    object Search : NavigationItem("search" , "Search" , Icons.Default.Search)
    object Settings : NavigationItem("settings" , "Settings" , Icons.Default.Settings)
}