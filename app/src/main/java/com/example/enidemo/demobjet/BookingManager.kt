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
    fun createBooking(customer: Person, persons : List<Person>, id : Int, isHotel : Boolean) : ManagerResponse {

        var response = ManagerResponse()

        // Si c'est u nhotel et qu'on veut reserver une chambre
        if (isHotel){
            // recupere l'hotel room via l'id
            response = ManagerResponse()
            var room = HotelRoom()
            var booking = Booking<HotelRoom>(persons, room)

            if (id < 1){
                // Reponse Metier RG-48589 : Error
                response.code = "705"
                response.message = "l'id n'est valide" + id
            }

            // Response Metier RG-48589
            response.code = Constantes.CD_SUCCESS_CMN
            response.message = "Chambre reservée avec succès"
            response.data = booking
        }
        else {
            // recupere un table dans le resto via l'id
            var table = Table()
            var booking = Booking<Table>(persons, table)

            // Response Metier RG-48510
            response.code = "203"
            response.message = "Table reservée avec succès"
            response.data = booking
        }

        return response;
    }

    fun testUnitaire(){
        var manager = BookingManager()

        var response = manager.createBooking(Person(), arrayListOf<Person>(Person()), 1, true)

        // Assert.equal(response.code, "202")

        // Log.i(response)
    }
}