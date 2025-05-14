package com.example.composebaseproject.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.padding(padding)
    ) {
        Text("Hello World")
    }

}