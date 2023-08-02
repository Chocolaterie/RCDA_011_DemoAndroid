package com.example.enidemo.demobjet

import android.util.Log
import com.example.enidemo.demoapi.Constantes

class BookingManager {

    /**
     * @param customer : La personne qui reserve
     * @param persons : Les personnes dans la reservation
     * @param id : L'id de l'element qu'on reserve : Attention ça peut être un Hotel ou une Table
     * @param isHotel : Pour savoir si le <T> ca va etre HotelRoom ou Table
     */
    fun createBookingRoom(customer: Person, persons: List<Person>, id: Int): ManagerResponse<BookingRoom> {

        var  response = ManagerResponse<BookingRoom>()

        // recupere l'hotel room via l'id
        var room = HotelRoom()
        var booking = BookingRoom(persons, room)

        if (id < 1) {
            // Reponse Metier RG-48589 : Error
            response.code = "705"
            response.message = "l'id n'est valide" + id
        }

        // Response Metier RG-48589
        response.code = Constantes.CD_SUCCESS_CMN
        response.message = "Chambre reservée avec succès"
        response.data = booking

        return response;
    }

    fun createBookingTable(customer: Person, persons: List<Person>, id: Int): ManagerResponse<BookingTable> {
        var response = ManagerResponse<BookingTable>()

        // recupere un table dans le resto via l'id
        var table = Table()
        var booking = BookingTable(persons, table)

        // Response Metier RG-48510
        response.code = "203"
        response.message = "Table reservée avec succès"
        response.data = booking

        return response
    }

    fun getAllBookingTable(): ManagerResponse<List<BookingTable>> {
        var response = ManagerResponse<List<BookingTable>>()

        // recupere un table dans le resto via l'id
        var table = Table()
        var booking = BookingTable(arrayListOf<Person>(), table)

        var bookins = arrayListOf<BookingTable>(booking, booking)

        // Response Metier RG-48510
        response.code = "203"
        response.message = "Table reservée avec succès"
        response.data = bookins

        return response
    }


    fun testUnitaire() {
        var manager = BookingManager()

        var response = manager.createBookingRoom(Person(), arrayListOf<Person>(Person()), 1)

        // Assert.equal(response.code, "202")
        var response2 = manager.getAllBookingTable()
        // Log.i(response)
    }
}