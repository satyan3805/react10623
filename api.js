const API_BASE = "https://your-api.com";

export const loginUser = async (credentials) => {
  const res = await fetch(`${API_BASE}/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(credentials),
  });

  if (!res.ok) {
    throw new Error("Invalid credentials");
  }

  return res.json(); // expect { token, user }
};
