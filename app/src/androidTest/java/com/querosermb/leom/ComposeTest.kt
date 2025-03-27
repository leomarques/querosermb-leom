package com.querosermb.leom

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.querosermb.leom.misc.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ComposeTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testListScreenDisplaysItems() {
        with(composeTestRule) {
            onNodeWithTag("listTopBar").assertIsDisplayed()
            onNodeWithText("error").assertDoesNotExist()
            onAllNodesWithTag("listItem").assertCountEquals(3)
        }
    }

    @Test
    fun testClickingItemOpensDetailsScreen() {
        with(composeTestRule) {
            onAllNodesWithTag("listItem")[0].performClick()
            onNodeWithTag("detailsTopBar").assertIsDisplayed()
        }
    }

    @Test
    fun testDetailsScreenDisplaysData() {
        with(composeTestRule) {
            onAllNodesWithTag("listItem")[0].performClick()
            onNodeWithTag("error").assertIsNotDisplayed()
            onNodeWithText("Name: Test Exchange").assertIsDisplayed()
            onNodeWithText("ID: 123").assertIsDisplayed()
            onNodeWithText("Website: example.com").assertIsDisplayed()
            onNodeWithText("Rank: 2").assertIsDisplayed()
        }
    }

    @Test
    fun testBackNavigationReturnsToListScreen() {
        with(composeTestRule) {
            onAllNodesWithTag("listItem")[0].performClick()
            onNodeWithTag("detailsTopBar").assertIsDisplayed()
            onNodeWithTag("backIcon").performClick()
            onNodeWithTag("listTopBar").assertIsDisplayed()
        }
    }
}
