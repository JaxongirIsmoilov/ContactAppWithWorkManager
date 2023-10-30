package uz.gita.jaxongir.contactappwithworkmanager.domain.params

data class ContactParam(
    val id: Int,
    val firstName:  String,
    val lastName: String,
    val phone: String,
    val state : Boolean
)
