class User {

    #id;
    #name;
    #secondName;

    constructor(id, name, secondName) {
        this.#id = id;
        this.#name = name;
        this.#secondName = secondName;
    }
}
export default User;