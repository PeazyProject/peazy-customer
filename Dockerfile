FROM gradle:6-jdk11
COPY ./ ./
RUN chmod 777 ./gradlew
RUN ./gradlew build -x test
ARG SAMPLE_FOLDER
ARG CHANNEL_TOKEN
ARG CHANNEL_SECRET
CMD java -jar ./build/libs/peazy-customer-0.0.1-SNAPSHOT.jar