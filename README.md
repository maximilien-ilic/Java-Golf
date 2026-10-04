> Started : 2026

<div align="center">

# Java Golf

A Spring Boot REST API to create golfers, build golf courses and simulate a match between two players.


![Contributors](https://img.shields.io/badge/contributors-1-blue)
![Forks](https://img.shields.io/badge/forks-0-blue)
![Stars](https://img.shields.io/badge/stars-0-yellow)
![Issues](https://img.shields.io/badge/issues-0_open-green)
![License](https://img.shields.io/badge/license-MIT-green)

</div>

---

## Table of Contents

1. [About the Project](#about-the-project)
   - [Built With](#built-with)
2. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
3. [Usage](#usage)
   - [API Endpoints](#api-endpoints)
   - [Postman Collection](#postman-collection)
   - [Step by Step](#step-by-step)
4. [Database](#database)
5. [Roadmap](#roadmap)
6. [Contributing](#contributing)
7. [License](#license)
8. [Contact](#contact)
9. [Acknowledgements](#acknowledgements)

---

## About the Project

This project exposes a small REST API around three objects: a **golfer**, a **course** (`terain`) made of several **holes** (`trou`), and a **match** between two golfers on a given course.

Golfers and courses are persisted with Spring Data JPA. A match draws a random score for each player, starting from the par of the course, and returns a sentence naming the winner — in golf the lowest score wins.

```
POST /game/play?joueur1=1&joueur2=2&terain=1

Sur le terrain GreenFEE (par 12) : raphael a fait 13 coups,
max a fait 16 coups. Le gagnant est raphael !
```

### Built With

- [Java 17](https://openjdk.org/)
- [Spring Boot 4.1.1](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/) / [H2](https://www.h2database.com/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

---

## Getting Started

### Prerequisites

- Java 17 or higher
- Docker and Docker Compose *(optional, only for the PostgreSQL setup)*
- [Postman](https://www.postman.com/) to call the API

### Installation

1. Clone the repository
```sh
git clone https://github.com/maximilien-ilic/Java-Golf.git
cd Java-Golf
```

2. Start the application — **with Docker** (PostgreSQL, data survives a restart)
```sh
docker compose up --build
```

3. Or **without Docker** (H2 in memory, data is lost on every restart)
```sh
./mvnw spring-boot:run
```

The API listens on `http://localhost:8080` in both cases. Maven does not need to be installed, `./mvnw` downloads it.

---

## Usage

### API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/golf/add` | Create a golfer (query parameters) |
| `GET` | `/golf/get?id=` | Read a golfer |
| `POST` | `/terain/add` | Create a course with its holes (JSON body) |
| `GET` | `/terain/get?id=` | Read a course |
| `POST` | `/game/play` | Play a match between two golfers |

### Postman Collection

Import `Golf.postman_collection.json` into Postman — **File → Import** — and run the folders in order, or hit **Run collection** to fire everything at once.

The collection ships with ready-made data (two golfers, two courses) and chains the requests automatically: the ids returned by the create calls are stored in collection variables and reused by the match request, so nothing has to be typed by hand.

### Step by Step

**1. Create the first golfer**
```http
POST http://localhost:8080/golf/add?nom=raphael&club=driver&handicap=10&swing=80&force=70
```
```json
{"nom":"raphael","club":"driver","handicap":10,"swing":80,"force":70,"id":1}
```

**2. Create the second golfer**
```http
POST http://localhost:8080/golf/add?nom=max&club=fer7&handicap=20&swing=40&force=50
```
```json
{"nom":"max","club":"fer7","handicap":20,"swing":40,"force":50,"id":2}
```

**3. Create a course** — Body → raw → JSON
```http
POST http://localhost:8080/terain/add
```
```json
{
  "nom": "GreenFEE",
  "dificulter": "Facile",
  "handicapNeccessaire": 50,
  "trous": [
    {"numero": 1, "par": 4, "distance": 350},
    {"numero": 2, "par": 3, "distance": 160},
    {"numero": 3, "par": 5, "distance": 480}
  ]
}
```
The response carries the generated ids — keep the course id for step 6.
```json
{"nom":"GreenFEE","dificulter":"Facile","handicapNeccessaire":50,"trous":[{"numero":1,"par":4,"distance":350,"id":1},{"numero":2,"par":3,"distance":160,"id":2},{"numero":3,"par":5,"distance":480,"id":3}],"id":1}
```

**4. Read a golfer**
```http
GET http://localhost:8080/golf/get?id=1
```

**5. Read the course**
```http
GET http://localhost:8080/terain/get?id=1
```

**6. Play the match** — the answer changes on every call
```http
POST http://localhost:8080/game/play?joueur1=1&joueur2=2&terain=1
```
```
Sur le terrain GreenFEE (par 12) : raphael a fait 13 coups, max a fait 16 coups. Le gagnant est raphael !
Sur le terrain GreenFEE (par 12) : raphael a fait 14 coups, max a fait 13 coups. Le gagnant est max !
Sur le terrain GreenFEE (par 12) : raphael a fait 12 coups, max a fait 12 coups. Egalite, personne ne gagne !
```

> **Order matters.** Ids start at 1 and are handed out in creation order. Calling step 6 before the golfers and the course exist returns HTTP 500 — `getById` calls `.get()` on an empty `Optional`. Same thing for any id that does not exist.

---

## Database

| Table | Columns |
|---|---|
| `golfer` | `id`, `nom`, `club`, `handicap`, `swing`, `force` |
| `terain` | `id`, `nom`, `dificulter`, `handicap_neccessaire` |
| `trou` | `id`, `numero`, `par`, `distance`, `terain_id` |

A course owns its holes through a `@OneToMany` relation: the link lives in a `terain_id` foreign key on the `trou` table, so creating a course inserts its holes in the same call.

The Docker setup also ships **Adminer** to browse the tables at `http://localhost:8081` — system `PostgreSQL`, server `db`, user `postgres`, password from `.env`, database `golf`.

---

## Roadmap

- [x] Create a golfer
- [x] Create a course with its holes
- [x] Persist everything with JPA
- [x] Play a match between two golfers and name the winner
- [x] Docker Compose setup with PostgreSQL and Adminer
- [ ] Score based on the golfer stats instead of a random draw
- [ ] Club selection and shot by shot simulation
- [ ] Handicap computed from the played rounds
- [ ] More than two players per match

---

## Contributing

Pull requests are welcome. For major changes, please open an issue first.

---

## License

Distributed under the MIT License.

---

## Contact

Maximilien Ilic — [LinkedIn](https://www.linkedin.com/in/maximilien-ilic/) — maximilien.ilic@gmail.com

---

## Acknowledgements

- Project built as part of the IIM Java course
- Spring Boot documentation and the Spring Initializr starter
