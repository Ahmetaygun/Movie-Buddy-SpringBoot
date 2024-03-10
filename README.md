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
- - Kullanıcılar yeni kayit olusturabilmeli ve kayitli kullanicilari listeleyebilmeli.
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

spring.datasource.driver-class-name=org.h2.Driver

server.port=8087

Yukarıdaki bilgileri kullanarak işlemlerinizi gerçekleştirebilirsiniz.
