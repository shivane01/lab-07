
package com.example.lab_7

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule =
        createAndroidComposeRule<MainActivity>()

    // Test 1: Walkthrough
    @Test
    fun navigate_to_races_add_race_and_return_home() {

        // Navigate to Upcoming Races
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // Verify we reached Upcoming Races
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // Enter Canada
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // Click Add
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // Verify Canada is displayed
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // Return to Home
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // Verify Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    // Test 2: Participation Exercise
    @Test
    fun navigate_add_clear_drivers_and_return_home() {

        // Navigate to Drivers
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // Verify Drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // Enter driver's name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        // Click Add
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver is displayed
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        // Clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify driver was removed
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // Return Home
        composeTestRule
            .onNodeWithTag("driverBackButton")
            .performClick()

        // Verify Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
