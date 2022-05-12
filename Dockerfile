FROM ubuntu:20.04

#RUN apt update && apt dist-upgrade -y


RUN mkdir /opt/moj_katalog
#RUN tar xf app.tar.gz -C /opt/moj_katalog --strip-components=1
#RUN mv jakis_plik.sqlite /opt/moj_katalog/wordnet
RUN rm /opt/app.tar.gz
EXPOSE 80/tcp

#STOPSIGNAL SIGTERM
WORKDIR /opt/moj_katalog
#CMD gunicorn --workers 2 --bind 0.0.0.0:80 app:app