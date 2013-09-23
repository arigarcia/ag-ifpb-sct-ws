#!/bin/sh

# Maven
case "$1" in
  --package)
     echo "start packaging..."
     mvn clean package
  ;;
  --none)
     echo "start without packaging..."
  ;;
  *)
     echo "none..."
  ;;
esac

# Run app
java -cp target/dependency/*:target/classes "$2"

