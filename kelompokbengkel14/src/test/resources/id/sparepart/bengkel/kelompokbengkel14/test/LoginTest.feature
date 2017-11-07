# language: id

Fitur: Melakukan Login
	Melakukan Login Admin

	@Normal
	Skenario: Melakukan login admin
		Dengan Data admin yang dimasukkan dan data admin tersedia dalam data yang telah ada di sistem
		Ketika Memasukkan data admin dengan "username" dan "password" 
		Maka respon sukses dengan pesan "login berhasil"

        @WrongUsername
        Skenario: Melakukan login admin
		Dengan Data admin yang dimasukkan dan username admin tidak tersedia dalam data yang telah ada di sistem
		Ketika Memasukkan data admin dengan "username salah" dan "password" 
		Maka respon gagal dengan pesan "username salah"
        
        @WrongPassword
        Skenario: Melakukan login admin
                Dengan Data admin yang dimasukkan dan password admin tidak tersedia dalam data yang telah ada di sistem
                Ketika Memasukkan data admin dengan "username" dan "password salah"
                Maka respon gagal dengan pesan "password salah"

        @WrongUsernameandWrongPassword
        Skenario: Melakukan login admin
                Dengan data admin yang dimasukkan dan data admin tidak tersedia dalam data yang telah ada di sistem
                Ketika Memasukkan data admin dengan "username salah" dan "password salah"
                Maka respon gagal dengan pesan "username dan password salah"
