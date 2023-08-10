FROM gradle:6.9-jdk11

WORKDIR /usr/src/admin
COPY . /usr/src/admin
VOLUME /tmp

RUN chmod +x run.sh && gradle updateLib

EXPOSE 8080

CMD [ "sh" , "run.sh" ]