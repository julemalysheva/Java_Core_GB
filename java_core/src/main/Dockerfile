FROM bellsoft/liberica-openjdk-alpine:16.0.1
LABEL authors="JuleMalysheva"
COPY ./java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/ru/gb/jcore/sample/Main.java
CMD java -classpath ./out ru.gb.jcore.sample.Main