(sleep 10; gradle buildAndReload --continuous -PskipDownload=true -x Test)&
gradle bootRun -PskipDownload=true -Dspring.profiles.active=development