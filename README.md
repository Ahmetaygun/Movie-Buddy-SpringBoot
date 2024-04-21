SistersLab'ın bitirme projesi olarak geliştirdiğimiz proje, Spring Boot teknolojisiyle hazırlandı.Projenin detayları aşağıda verilmiştir.

Proje Adı: Film Arkadaşı

Amaç:
Bu proje, Spring Boot ve temel CRUD (Create, Read, Update, Delete) işlemlerini anlamanıza
yardımcı olacak bir film izleme uygulaması geliştirmemizi amaçlamıştır. Bu proje aynı
zamanda ilişkisel veritabanı yönetimi ve RESTful web servisleri konularında da deneyim
kazandırmıştır.

Gereksinimler:
1. **Kullanıcı Yönetimi:**
- Kullanıcılar, ad, username, mail ,password gibi özelliklerle birlikte veritabanında
saklanabilmelidir.
- Kullanıcılar yeni kayit olusturabilmeli ve kayitli kullanicilari listeleyebilmeli.
- Kayıtlı kullanıcılar, parolalarını güncelleyebilmeli ve hesaplarını silebilmelidir.
- Kayıtlı kullanıcıların hepsi listelene bilmeli.
2. **Film Yönetimi:**
- Filmler, ad, açıklama, yayın tarihi ve puan gibi özelliklerle birlikte veritabanında
saklanabilmelidir.
- Kullanıcılar, filmleri listeleyebilmeli, yeni film ekleyebilmeli, mevcut filmleri
düzenleyebilmeli ve silebilmelidir.
3. **İzleme Listesi (Watchlist):**
- Kullanıcılar, izlemek istedikleri filmleri bir izleme listesine ekleyebilmeli, bu listeden filmleri
kaldırabilmeli ve izlenen filmleri işaretleyebilmelidir.
- İzleme listesi, kullanıcı ve film arasında Many-to-Many ilişkisiyle oluşturulmalıdır.

  
Teknik Detaylar:
1. **Spring Boot:**
- Uygulama, Spring Boot kullanılarak geliştirilmiştir.
2. **Veritabanı:**
- İlişkisel bir veritabanı  H2 kullanılmaktadır.
- JPA (Java Persistence API) kullanılarak veritabanı işlemleri
gerçekleştirilmelidir.
3. **RESTful Web Servisleri:**
- Film ve kullanıcı işlemleri için RESTful API'lar oluşturulmuştur.
- API'lar, JSON formatında veri döndürmektedir.

Projenin veritabanı yönetimi için http://localhost:8087/h2-console/ adresini kullanabilirsiniz. Veritabanı yapılandırması aşağıdaki gibidir:

spring.datasource.url=jdbc:h2:mem:dcbapp

spring.datasource.username=sa

spring.datasource.password=password


///////////////
The project we developed as the final project of SistersLab is prepared with Spring Boot technology. The details of the project are provided below.

Project Name: Movie Buddy

Purpose: This project aims to help you develop a movie-watching application that will help you understand Spring Boot and basic CRUD (Create, Read, Update, Delete) operations. This project also provides experience in relational database management and RESTful web services.

Requirements:

User Management:
Users should be able to be stored in the database with properties such as name, username, email, password, etc.
Users should be able to create new accounts and list registered users.
Registered users should be able to update their passwords and delete their accounts.
All registered users should be listable.
Movie Management:
Movies should be able to be stored in the database with properties such as name, description, release date, and rating.
Users should be able to list movies, add new movies, edit existing movies, and delete movies.
Watchlist:
Users should be able to add movies they want to watch to a watchlist, remove movies from this list, and mark watched movies.
The watchlist should be created with a Many-to-Many relationship between users and movies.
Technical Details:

Spring Boot:
The application is developed using Spring Boot.
Database:
A relational database H2 is used.
Database operations should be performed using JPA (Java Persistence API).
RESTful Web Services:
RESTful APIs have been created for movie and user operations.
APIs return data in JSON format.
You can use http://localhost:8087/h2-console/ for database management of the project. The database configuration is as follows:

spring.datasource.url=jdbc:h2:mem:dcbapp

spring.datasource.username=sa

spring.datasource.password=password

spring.datasource.driver-class-name=org.h2.Driver

server.port=8087

You can perform your operations using the above information.

spring.datasource.driver-class-name=org.h2.Driver

server.port=8087

Yukarıdaki bilgileri kullanarak işlemlerinizi gerçekleştirebilirsiniz.
