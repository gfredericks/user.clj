# user.clj

user.clj is a library that consists of a `user.clj` file that can load
other user files.

The immediate problem it's meant to solve is that the user-level
`deps.edn` file can't reference `$HOME`-relative paths as a way of
providing your own `user.clj` directly.

## Obtention

### `deps.edn`

```
:deps {com.gfredericks/user.clj {:mvn/version "0.1.0"}}
```

## Usage

If this library is on your classpath and there aren't any other
`user.clj` files on the classpath, then the following will happen:

- `$HOME/.clojure/user.clj` will be loaded, if it exists

## License

Copyright © 2018 Gary Fredericks

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
