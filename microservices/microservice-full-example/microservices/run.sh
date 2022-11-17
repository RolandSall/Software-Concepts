VERSION=1.0-SNAPSHOT

mvn clean install

cd ./fraud
docker build -t rolandsall24/fraud:$VERSION .

cd ../notification
docker build -t rolandsall24/notification:$VERSION .

cd ../gateway
docker build -t rolandsall24/gateway:$VERSION .

cd ../customer
docker build -t rolandsall24/customer:$VERSION .

cd ../discovery
docker build -t rolandsall24/discovery:$VERSION .