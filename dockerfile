FROM openjdk:13

RUN yum install unzip -y
RUN curl -SsL https://downloads.gauge.org/stable | sh
RUN gauge config plugin_kill_timeout 60000
RUN gauge config runner_request_timeout 60000
RUN gauge config runner_connection_timeout 60000
RUN gauge config plugin_connection_timeout 60000
COPY . /src
WORKDIR /src