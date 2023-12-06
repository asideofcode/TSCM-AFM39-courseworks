CC=gcc
CFLAGS=-I.
# DEPS = lib.h
OBJ_TEST = out/lib.o out/test_lib.o
OUT_DIR = out

run: out/test
	./out/test

# Update the pattern rule to use the output directory
$(OUT_DIR)/%.o: %.c $(DEPS) | $(OUT_DIR)
	$(CC) -c -o $@ $< $(CFLAGS)

# You may also want to add a rule to create the output directory if it doesn't exist
$(OUT_DIR):
	mkdir -p $(OUT_DIR)

out/test: $(OBJ_TEST)
	$(CC) -o $@ $^ $(CFLAGS)

.PHONY: clean

clean:
	rm -rf out

