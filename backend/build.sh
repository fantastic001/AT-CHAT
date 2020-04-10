#!/bin/sh


BACKEND_DIR="$(readlink -f $(dirname $0))"
pushd .
cd "$BACKEND_DIR"
APPNAME="$(ls -d *-ear | sed "s/-ear//g")"
popd

docker run \
	-it --rm \
	--name prodex_api_build \
	-v "$BACKEND_DIR/":/usr/src/mymaven/ \
	-w /usr/src/mymaven \
	maven mvn clean package


if [ $? = 0 ]; then 
	echo "Successfully build $APPNAME"
fi

rm -rf "$BACKEND_DIR/target" 
mkdir -p "$BACKEND_DIR/target" 
cp -r "$BACKEND_DIR/$APPNAME-ear/target/$APPNAME-ear.ear" "$BACKEND_DIR/target"

