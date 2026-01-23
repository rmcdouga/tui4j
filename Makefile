SHELL := /bin/sh

.PHONY: build
build:
	./gradlew build --rerun-tasks --no-configuration-cache

.PHONY: build-notest
build-notest:
	./gradlew build -x test --rerun-tasks --no-configuration-cache

.PHONY: test
test:
	./gradlew test --rerun-tasks --no-configuration-cache

.PHONY: clean
clean:
	./gradlew clean --no-configuration-cache
