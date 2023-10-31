package uz.gita.jaxongir.contactappwithworkmanager.data.source.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import uz.gita.jaxongir.contactappwithworkmanager.data.request.ContactRequest
import uz.gita.jaxongir.contactappwithworkmanager.data.response.ContactResponse

interface ContactApi {

    @POST("contact")
    fun addContact(contactRequest: ContactRequest) : Response<ContactResponse>

    @GET("contact")
    fun getAllContacts() : Response<List<ContactResponse>>

}