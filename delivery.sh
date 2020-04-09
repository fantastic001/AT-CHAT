#!/bin/bash


DELIVERY="$(readlink -f ./delivery)"



CURRENT="$(readlink -f $(dirname $0))"
cd "$CURRENT"

echo "Deliverying frontend to $DELIVERY"

cd frontend
npm install
npm run-script build

mkdir -p $DELIVERY/frontend
cp -r dist/ $DELIVERY/frontend
cp index.html $DELIVERY/frontend

cd .. 

echo "Deliverying backend to $DELIVERY"

cd prodex-rest-api

BACKEND_DIR="$(readlink -f .)"
SOURCE_DIR="$BACKEND_DIR/src/main/java"
RESOURCES_DIR="$BACKEND_DIR/src/main/resources"
TEST_DIR="$BACKEND_DIR/src/test"

docker run \
	-it --rm \
	--name prodex_api_build \
	-v "$BACKEND_DIR/":/usr/src/mymaven/ \
	-w /usr/src/mymaven \
	maven mvn clean install


DATA_DIR="$BACKEND_DIR/data"


if [ -d /tmp/prodex_data ]; then 
	rm -rf /tmp/prodex_data
fi

cp -r "$DATA_DIR" $DELIVERY/

mkdir -p $DELIVERY/webapps

cp -r target/*.war $DELIVERY/webapps

cd .. 

echo "Delivery of nginx configuration"
cd frontend
cp -r nginx $DELIVERY/

cd .. 


echo "Pack the source code..."

zip src.zip -r \
	frontend/App.vue \
	frontend/index.html \
	frontend/routes.js \
	frontend/src/ \
	frontend/README.md \
	frontend/index.js \
	frontend/package.json \
	frontend/webpack.config.js \
	prodex-rest-api/src/


mkdir -p $DELIVERY/code
mv src.zip $DELIVERY/code

echo "Packing up delivery..."
zip delivery.zip -r $DELIVERY 

echo "Remove temporary files"
rm -rf delivery/

