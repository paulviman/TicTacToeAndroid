# TicTacToeAndroid

TicTacToe, cunoscut in romana ca X și 0, este un joc interactiv ce este format dintr-o tabela de joc de 3x3 poziți. Jocul se joaca cu 2 jucatori, primul jucator are simbolul X, iar cel de-al doilea are simbolul 0. Scopul jocului este de a face un rand, o coloana sau o diagonala sa contine simbolurile jucatorului.

Pentru inceput am creat o activitate principala, aceasta contine o imagine, 2 butoane si un element ascuns
“Start Local” - deschide o noua activitate ce continue jocul propriu-zis si ambi jucatori sunt utilizatorul/I
“Start With CPU” – deschide aceeasi activitate, doar ca de aceasta data al doilea jucator este telefonul ce genereaza pozitia
![image](https://user-images.githubusercontent.com/74013994/212561076-84e3e9b5-2d2f-460f-a0e1-43a43175d824.png)

Elementul ascuns este defapt o utilizare a senzorului de acceleratie. Cand senzorul inregistreaza o acceleratie ce depaseste 1.005 acesta afiseaza un mesaj amuzant pe un fundal colorat aleator ce se schimba o data la o secunda
![image](https://user-images.githubusercontent.com/74013994/212561253-d29b4f6e-7b87-4076-936e-43173e8657e6.png)


In acesta activitate avem table de joc alcatuita din 9 butoane asezate matricial 3x3 
2 butoane: reset – acesta reseteaza table de joc ; back – ma intoarce la activitatea principala
2 textView: unul pentru afisarea de mesaje in timpul jocului, iar celalat pentru afisarea timpului pentrecut in runda respectiva
![image](https://user-images.githubusercontent.com/74013994/212561093-be189664-6c86-4ef5-ae09-872821295c70.png)


Aspectul si functionalitatea acestui mod este acelasi cu modul Local, insa aici odata ocupata o pozitie de catre utilizator, telefonul ocupa si el o pozitie. Aceasta functionalitate este create printr-o functie ce genereaza o pozitie random si verifca daca nu cumva pozitia este deja ocupata





