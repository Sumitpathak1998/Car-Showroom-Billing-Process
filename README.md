# Car-Showroom-Billing-Process
By using hibernate mapping concept generate car showroom bills

This Project i mainly using Hibernate mapping concept like @onetone , @onetomany and @manytoone.
Here Five Entity classes i make 
1) Person - with the Person entity class i map person address and PAN by the help of @Onetoone mapping.so, at the time we persist the person details there addrss and PAN detsils also added with them.
2) Address - Hold the detsils of Address of Person 
3) PAN - Hold the details on PAN detsils , PAN and address class also mapped with  @onetoone mapping so that with the PAN we required to add the address details which can be add easily.
4) CAR - Hold the detsils of CAR , CAR and Person is mapped with @manytoone and @onetoMany becz, one person may have more then one car 
5) CarBooking - This entity class i make for car booking perpose it share the @onetone mapping relation with Car and Person at the time Person book the car then both Car and Person details meerge and Bill is generate. 
