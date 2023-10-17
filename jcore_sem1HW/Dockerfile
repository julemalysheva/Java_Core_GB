FROM openjdk:20
COPY ./src/main/java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/hw/program/Main.java
CMD java -classpath ./out hw.program.Main