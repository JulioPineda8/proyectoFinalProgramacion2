package com.example.poryectofinal.CarpetaPantalladeLogin.navigation.screens.login

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.poryectofinal.CarpetaPantalladeLogin.navigation.MascotaScreens


@Composable
fun MascotaLoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    //True es para Login y Flase para Crear Cuenta
    val showLoginForm = rememberSaveable{
        mutableStateOf(true)
    }
    Surface(modifier = Modifier
        .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if(showLoginForm.value){
                Text(
                    text = "Iniciar Sesión",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp, // Ajusta el tamaño de la fuente según tus preferencias
                    modifier = Modifier.padding(3.dp)
                )
                UserForm(
                    isCreateAccount = false
                ){
                    email, password ->
                    Log.d("Lo encontramos", "Logueando con $email y $password")
                    viewModel.signInWithEmailAndPassword(email, password){
                        navController.navigate(MascotaScreens.MascotaHomeScreen.name)
                    }
                }
            }
            else{
                Text(text = "Crea una Cuenta")
                UserForm(
                    isCreateAccount = true
                )
                {
                        email, password ->
                        Log.d("Lo encontramos", "Creando Cuenta con $email y $password")
                        viewModel.createUserWithEmailandPassword(email, password){
                            navController.navigate(MascotaScreens.MascotaHomeScreen.name)
                        }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val text1 =
                    if (showLoginForm.value)"No tienes Cuenta?"
                    else "Ya tienes una Cuenta?"
                val text2 =
                    if (showLoginForm.value)"Registrate"
                    else "Inicia Sesión"
                Text(text = text1)
                Text(text = text2,
                    modifier = Modifier
                        .clickable { showLoginForm.value = !showLoginForm.value }
                        .padding(start = 5.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAccount: Boolean = false,
    OnDone: (String, String) -> Unit = {email, pwd ->}
) {
    val email = rememberSaveable{
        mutableStateOf("")
    }
    val password = rememberSaveable{
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable{
        mutableStateOf(false)
    }
    val valido = remember(email.value, password.value){
        email.value.trim().isNotEmpty() &&
                password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password,
            labelId = "Contraseña",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId = if (isCreateAccount) "Crear Cuenta" else "Login",
            inputValido = valido
        ){
            OnDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()
        }
    }
}

@Composable
fun SubmitButton(
    textId: String,
    inputValido: Boolean,
    onClic: ()->Unit
) {
    Button(onClick = onClic,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValido
        ) {
        Text(text = textId,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    val visualTransformation = if (passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = { Text(text = labelId)},
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank()){
                PasswordVisibleIcon(passwordVisible)
            }
            else null
        }
    )
}

@Composable
fun PasswordVisibleIcon(
    passwordVisible: MutableState<Boolean>
) {
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
    else
            Icons.Default.Visibility
    IconButton(onClick = {
        passwordVisible.value = !passwordVisible.value
    }) {
        Icon(
            imageVector = image,
            contentDescription = "")
    }
}


@Composable
fun EmailInput(
    emailState: MutableState<String>,
    labelId : String = "Email"
) {
    InputField (
        valueState = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it},
        label = { Text(text = labelId)},
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}
