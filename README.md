# ⚽ UEFA Champions League Draw Simulator

A Python project that allows you to simulate the **UEFA Champions League League Phase Draw**, generating opponents for each club in a realistic and organized way. The simulation uses team ranking order to create the pots and then performs the draw automatically.

Perfect for football fans who want to simulate the biggest club competition in the world! 🌍🔥

---

## 📋 Description

This project simulates a **UEFA Champions League draw** using a list of teams provided by the user.  
Teams must be inserted in ranking order (you can follow the official UEFA ranking if you want), and the program will create the pots based on the order of the file.

After the simulation, each team will receive its opponents list, with **Home (H)** and **Away (A)** indicators.

---

## ✨ Features

- 🏆 Simulate the UEFA Champions League draw system
- 📄 Teams input via `teams.txt`
- 🎯 Pots automatically generated based on team ranking order
- ⚔️ Opponent list generated for each team
- 🏠✈️ Home/Away match indicator
- 🖥️ Graphical interface (GUI)

---

## 🛠️ Technologies Used

- JAVA SE 23
- 
- File handling (`.txt` input)

---

## 📁 Project Structure

Teams list (`teams.txt`) → pots creation → draw simulation → opponents list with Home/Away results.

---

## 📂 Folder / File Structure

- `teams.txt` → File where you insert the teams (in ranking order)
- `main.py` → File to run the simulator
- GUI classes (`Window_1`) → Responsible for the draw interface and simulation

---

## 📝 Teams Input Format

To simulate correctly, you must write teams in `teams.txt` using this format:

txt
    Team Name,Country

    ✅ Example

    Real Madrid,Spain

    Manchester City,England

    Bayern Munchen,Germany

    Paris Saint-Germain,France

    Inter Milan,Italy

## ⚠️ Important Notes

- Teams must be written in ranking order (top teams first).
- You may add more than 36 teams, but you will need to select only 36 before simulating.
- The pots will be generated based on the order of the teams in the file.


## 🏠✈️ Home and Away System

In the result output, opponents will appear with:

- (H) → Home 🏠
- (A) → Away ✈️

Example:

Real Madrid:
- Bayern Munchen (H)
- PSG (A)
- Arsenal (H)

---

## ▶️ How to Run

  bash

    https://github.com/HenriqueSM0/UEFA_champions_league_first_phase_draw
    cd UEFA_champions_league_first_phase_draw
Run the project:

To start the draw simulation, run the main function of the Window_1 class.

---

## 🎮 How to Use

-Fill teams.txt with the clubs in ranking order.
-Run the program.
-Select the teams (if more than 36 are present).
-Start the simulation.
-View the results showing each team and their opponents list.
