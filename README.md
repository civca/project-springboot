# project-springboot

Projekat je radjen u NetBeans-u, Maven based.

Prije pokretanja projekta, potrebno je instalirati PostgreSQL i izvrsiti prilozenu skriptu (postal_dump).
Nalog na bazi: 
	-user name: postgres
	-password: postgres

Nalozi za pristup servisu se nalaze u bazi:
	-user name: user_1, password: user_1
	-user name: user_2, password: user_2

## Poziv servisa koji racuna distancu između dva post koda:
	GET metoda
	localhost:8080/postalService/getDistanceBetween/{postalFrom}/{postalTo}

	-primjer:localhost:8080/postalService/getDistanceBetween/WC2N 5DU/L2 2DP

## Poziv servisa koji daje sve podatke za određeni post kod:
	GET metoda
	localhost:8080/postalService/getPostal/{postCode}

	-primjer:localhost:8080/postalService/getPostal/WC2N 5DU

## Poziv servisa za update lat i lng za određeni post kod:
	PUT metoda
	localhost:8080/postalService/updateLatLng/{postCode}
		{
		"latitude":"value",
		"longitude":"value"
		}

	primjer:localhost:8080/postalService/updateLatLng/WC2N 5DU
		{
		"latitude":"51.50721",
		"longitude":"0.136534"
		}

