export default class User {

    #id;
    #name;
    #secondName;

    constructor(id, name, secondName) {
        this.#id = id;
        this.#name = name;
        this.#secondName = secondName;
    }

    get id() {
        return this.#id;
    }

    get name() {
        return this.#name;
    }

    get secondName() {
        return this.#secondName;
    }
}