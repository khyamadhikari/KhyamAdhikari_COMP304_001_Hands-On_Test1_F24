// Student ID: 300868207
package com.khyam.adhikari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khyam.adhikari.ui.theme.MyContactsTheme

// Student ID: 300868207

class AdhikariActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContactsTheme {
                AddContactScreen()
            }
        }
    }
}

// Data model for Contact
data class Contact(val name: String, val phone: String, val email: String, val type: String)

// ViewModel for handling the list of contacts
class ContactViewModel : ViewModel() {
    var contacts by mutableStateOf(listOf<Contact>())
        private set

    fun addContact(contact: Contact) {
        contacts = contacts + contact
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(viewModel: ContactViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var contactType by remember { mutableStateOf("Friend") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Add New Contact", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Radio buttons for contact type selection
        Row {
            RadioButton(
                selected = contactType == "Friend",
                onClick = { contactType = "Friend" }
            )
            Text(text = "Friend")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = contactType == "Family",
                onClick = { contactType = "Family" }
            )
            Text(text = "Family")

            Spacer(modifier = Modifier.width(8.dp))

            RadioButton(
                selected = contactType == "Work",
                onClick = { contactType = "Work" }
            )
            Text(text = "Work")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Add the contact
            if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()) {
                viewModel.addContact(Contact(name, phone, email, contactType))

                // Clear input fields after adding the contact
                name = ""
                phone = ""
                email = ""
                contactType = "Friend" // Reset contact type to default
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add Contact")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the list of added contacts
        LazyColumn {
            items(viewModel.contacts) { contact ->
                Text(text = "${contact.name}, ${contact.phone}, ${contact.email}, ${contact.type}")
            }
        }
    }
}
