package com.devgah.loginflow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devgah.loginflow.screen.ForgotPassword
import com.devgah.loginflow.screen.Login
import com.devgah.loginflow.screen.NewPassword
import com.devgah.loginflow.screen.Page
import com.devgah.loginflow.screen.SignUp
import com.devgah.loginflow.screen.VerifyCode

@Composable
fun NavHostController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            Login(
                onLoginSucess = { email ->
                    navController.navigate("page/$email") {
                    }
                },
                onForgotPassword = {
                    navController.navigate("forgotPassword")
                },
                onSignUp = {
                    navController.navigate("signUp")
                }
            )
        }

        composable("forgotPassword") {
            ForgotPassword(
                onBack = {
                    navController.navigate("login")
                },
                onVerifyCode = {
                    navController.navigate("verifyCode")
                }
            )
        }

        composable("verifyCode") {
            VerifyCode(
                onNewPassword = {
                    navController.navigate("newPassword")
                },
            )
        }

        composable("newPassword") {
            NewPassword(
                onBack = {
                    navController.navigate("login")
                }
            )
        }
        composable("signUp") {
            SignUp(
                onPage = { email ->
                    navController.navigate("page/$email") {
                        popUpTo("signUp") { inclusive = true }
                    }
                },
                onSignUp = {
                    navController.navigate("login") {
                        popUpTo("signUp") { inclusive = true }
                    }
                }
            )
        }

        composable("page/{email}") { entry ->
            entry.arguments?.getString("email").let { email ->
                if (email != null) {
                    Page(
                        onBack = {
                            navController.navigate("login") {
                                popUpTo("page/{email}")
                            }
                        },
                        email = email
                    )
                }
            }
        }
    }
}