export interface ProfileEdit {
id: number;
firstName: string;
lastName: string;
displayName: string;
email: string;
location: string;
status: string;
bio: string;
profileImageURL: string;
habits: Habits[];
habitSettings: HabitSettings[];
}

export interface Habits {
    id: number;
    name: string;
    description: string;
}

export interface HabitSettings {
    id: number;
    active: boolean;
    complete: boolean;
    hidden: boolean;
}