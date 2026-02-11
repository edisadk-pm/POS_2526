//basic code: SERVER.TS

import express from "express";
import { Router, Request, Response } from "express";
import type {Player} from "./models/types";
import  {PlayerDB} from "./models/db.models";
import mockplayers from "./mockdata/mockdaten.json";

const PORT =  process.env.PORT || 3000;
const app = express();

//middleware
app.use(express.json()); //warum brauchen wir das? -> damit wir den body der request lesen können, z.B. bei POST requests
//app.use(express.cors()); //warum brauchen wir das? -> damit wir von anderen domains aus auf unseren server zugreifen können, z.B. von einem frontend, das auf localhost:3001 läuft

/**
 * Routen Anwenden in der Middleware
 */
const playersRouter:Router = Router();

playersRouter.get("/", async (req, res) => {
    try{

    // const players = mockplayers as Player[];
    const players:Player[] = await PlayerDB.find() as Player[];
    res.status(200).json(players);
    } catch (err) {
        const error = err as Error;
        console.error("GET:err: " + err);
        res.status(500).json({error: "Internal Server Error"});
    }

})

app.use("/api/players", playersRouter);


//start:
app.listen(PORT, () => {
    console.log("server is running on port " + PORT);
})
