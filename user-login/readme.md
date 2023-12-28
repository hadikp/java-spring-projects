Vite-login Vue projekt login komponense betölti az adatbázisból a user-t, és a 
vue pinia tárolójába rakja. Csak akkor tölti be a user-t, ha jó a username password kombináció.
A spring-boot security még nem működik tökéletesen, kénytelen voltam a SecurityConfig
file-ban minden oldal hozzáférést engedélyezni (requestMatchers("/api/**").permitAll()).