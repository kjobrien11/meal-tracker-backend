INSERT INTO Food (name, calories_per_gram, created_at)
VALUES ('Granola', 3.667, current_timestamp);

INSERT INTO Food (name, calories_per_gram, created_at)
VALUES ('Chia Seeds', 5.333, current_timestamp);

INSERT INTO Food (name, calories_per_gram, created_at)
VALUES ('Honey', 2.857, current_timestamp);

INSERT INTO Food (name, calories_per_gram, created_at)
VALUES ('Greek Yogurt', 0.5294, current_timestamp);

INSERT INTO Food (name, calories_per_gram, protein_per_gram, carbs_per_gram, fat_per_gram,  created_at)
VALUES ('90/10 Ground Beef', 1.785714,0.196428, 0, 0.098214, current_timestamp);

INSERT INTO Food (name, calories_per_gram, protein_per_gram, carbs_per_gram, fat_per_gram, created_at)
VALUES ('93/7 Ground Turkey (Cooked in Olive Oil', 1.696428, 0.196428, 0, 0.080357,  current_timestamp);

INSERT INTO Food (name, calories_per_gram, created_at)
VALUES ('Roasted Potato Wedges (Cooked in Olive Oil)', 1.0,  current_timestamp);

INSERT INTO Food (name, calories_per_gram, created_at)
VALUES ('Roasted Sweet Potato Wedges (Cooked in Olive Oil) *ESTIMATE*', 1.0, current_timestamp);


INSERT INTO Meal (meal_name, date, created_at) VALUES ('Lunch', CURRENT_DATE, current_timestamp);